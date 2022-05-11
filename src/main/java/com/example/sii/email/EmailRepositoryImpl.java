package com.example.sii.email;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepositoryImpl implements EmailRepository {


  @Override
  public void saveNotification(Email email) {

    try(FileWriter fileWriter = new FileWriter("notification.txt", true);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

      printWriter.println(email.toString());

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
