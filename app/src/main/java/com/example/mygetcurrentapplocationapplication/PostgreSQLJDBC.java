package com.example.mygetcurrentapplocationapplication;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PostgreSQLJDBC {

    public void connectionMethod(double latit,double longtit)
    {
        Connection c = null;
        PreparedStatement stmt = null;
        try {
            Log.i("methodtamam","inside method");
            //Connection
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/testdb",
                            "root", "");
            c.setAutoCommit(false);
            Log.i("cnxtamam","Opened database successfully");

            //Insertion
            String sql = "INSERT INTO position VALUES(?, ?, 1, Asmaa);";
            stmt = c.prepareStatement(sql);
            stmt.setDouble(1, latit);
            stmt.setDouble(2, longtit);
            stmt.executeUpdate();

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        Log.i("inserttamam","Records created successfully");

    }
}
