package com.wildcodeschool.myProjectWithDB.controllers;

import com.wildcodeschool.myProjectWithDB.models.Wizard;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class WizardController {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/wild_db_quest?serverTimezone=GMT";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "root";

    @GetMapping("/api/wizards")
    List<Wizard> getWizards(@RequestParam(required = false) String family) {

        String sql = "SELECT * FROM wizard WHERE lastname LIKE ?";

        if (family == null) {
            family = "%";
        }

        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setString(1, family);

            try (ResultSet resulSet = statement.executeQuery()) {

                List<Wizard> wizards = new ArrayList<Wizard>();

                while (resulSet.next()) {
                    int id = resulSet.getInt("id");
                    String firstname = resulSet.getString("firstname");
                    wizards.add(new Wizard(id, firstname));
                }

                return wizards;
            }

        } catch (SQLException e) {
            // send HttpStatus 500 to the client if something goes wrong
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "", e);
        }
    }

}

