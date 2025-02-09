package org.example;

import org.sqlite.mc.SQLiteMCConfig;

import java.sql.*;

public class Main {
  public static void main(String[] args) {

    // URI パラメータ key を設定することでパスフレーズを設定することができる
    // デフォルトの Cipher は Chacha20 となっている
    // @see https://utelle.github.io/SQLite3MultipleCiphers/docs/configuration/config_uri/
    try (Connection connection =
            new SQLiteMCConfig.Builder()
                .withKey("Key")
                .build()
                .createConnection("jdbc:sqlite:file:sample.db"); // Using Chacha20
        Statement statement = connection.createStatement()) {
      statement.setQueryTimeout(30);

      statement.executeUpdate("drop table if exists person");
      statement.executeUpdate("create table person (id integer, name string)");
      statement.executeUpdate("insert into person values (1, 'leo')");
      statement.executeUpdate("insert into person values (2, 'yui')");

      ResultSet rs = statement.executeQuery("select * from person");

      while (rs.next()) {
        System.out.println(rs.getInt("id") + " " + rs.getString("name"));
      }
    } catch (SQLException e) {
      e.printStackTrace(System.err);
    }
  }
}
