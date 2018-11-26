package java3.lesson2;

import java.sql.*;
import java.util.Scanner;

/**
 * Java3. Lesson 2. Homework.
 *
 * @author Ilya Kukushkin
 * @version 26 Nov 2018
 * <p>
 * Сформировать таблицу товаров (id, prodid, title, cost) запросом из Java-приложения:
 * id – порядковый номер записи, первичный ключ;
 * prodid – уникальный номер товара;
 * title – название товара;
 * cost – стоимость.
 * <p>
 * При запуске приложения очистить таблицу и заполнить 10000 товаров вида:
 * id_товара 1 товар1 10
 * id_товара 2 товар2 20
 * id_товара 3 товар3 30
 * id_товара 10000 товар10000 100000
 * <p>
 * Написать консольное приложение, которое позволяет узнать цену товара по его имени, либо
 * вывести сообщение «Такого товара нет», если товар не обнаружен в базе. Консольная
 * команда: «цена товар545».
 * <p>
 * Добавить возможность изменения цены товара. Указываем имя товара и новую цену.
 * Консольная команда: «сменитьцену товар10 10000».
 * <p>
 * Вывести товары в заданном ценовом диапазоне. Консольная команда: «товарыпоцене 100
 * 600»
 */

public class LessonJDBC {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static Scanner scanner;
    private static String userInput;
    private static String sqlQuery;

    public static void main(String[] args) {

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.execute("CREATE TABLE IF NOT EXISTS products (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "prodid TEXT UNIQUE NOT NULL," +
                    "title TEXT NOT NULL," +
                    "cost INTEGER NOT NULL)");
            statement.executeUpdate("DELETE FROM products");

            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("INSERT INTO products (prodid, title, cost)" +
                    " VALUES (?, ?, ?)");

            for (int i = 1; i <= 10000; i++) {
                preparedStatement.setString(1, "id_товара " + i);
                preparedStatement.setString(2, "товар" + i);
                preparedStatement.setInt(3, (i * 10));
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

            connection.setAutoCommit(true);

            scanner = new Scanner(System.in);

            System.out.println("Введите:\n" +
                    "1. Для уточнения цены - цена название_товара\n" +
                    "2. Для изменения цены - сменитьцену название_товара новая_цена\n" +
                    "3. Для вывода всех товаров с определенной ценой - товарыпоцене цена\n" +
                    "4. Для выхода - quit");

            do {
                userInput = scanner.nextLine();
                if (userInput.startsWith("цена")) {

                    String[] query = userInput.split(" ");
                    sqlQuery = String.format("SELECT * FROM products WHERE title = '%s'", query[1]);

                    ResultSet resultSet = statement.executeQuery(sqlQuery);

                    if (resultSet.next()) {
                        System.out.println("Цена: " + resultSet.getString("cost"));
                    } else {
                        System.out.println("Такого товара нет");
                    }
                }
                if (userInput.startsWith("сменитьцену")) {

                    String[] query = userInput.split(" ");

                    sqlQuery = String.format("UPDATE products SET cost = '%s' WHERE title = '%s'", query[2], query[1]);

                    int result = statement.executeUpdate(sqlQuery);
                    System.out.println("Цена товара " + query[1] + " изменена на " + query[2]);
                }
                if (userInput.startsWith("товарыпоцене")) {

                    String[] query = userInput.split(" ");
                    sqlQuery = String.format("SELECT * FROM products WHERE cost = '%s'", query[1]);

                    ResultSet resultSet = statement.executeQuery(sqlQuery);

                    while (resultSet.next()) {
                        System.out.println("Товар " + resultSet.getString("title") + " цена " +
                                resultSet.getString("cost"));
                    }
                }
            } while (!userInput.equals("quit"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        statement = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
