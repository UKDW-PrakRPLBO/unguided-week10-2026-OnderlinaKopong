package org.rplbo.app.ug8.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.rplbo.app.ug8.UmbrellaApp;
import org.rplbo.app.ug8.UmbrellaDBManager;
import javafx.scene.control.Label;

import java.io.IOException;


public class LoginController {
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblStatus;

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        // ==============================================================================
        // TODO 1: PROSES AUTENTIKASI (LOGIN)
        // ==============================================================================
        // 1. Ambil input teks dari txtUsername dan txtPassword.
        // 2. Buat instansiasi dari class UmbrellaDBManager.
        // 3. Panggil metode validateUser() dari db manager tersebut.
        // 4. Jika hasil validasi berhasil (tidak null):
        //    a. Simpan nama user ke variabel statis UmbrellaApp.loggedInUser.
        //    b. Pindah ke halaman "umbrella-view.fxml" menggunakan UmbrellaApp.switchScene().
        // 5. Jika gagal, tampilkan pesan error "AUTHENTICATION FAILED" pada lblStatus.
        // ==============================================================================

        // --- TULIS KODE ANDA DI BAWAH INI ---
        // 1. Ambil input username dan password
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        // 2. Instansiasi DB Manager
        UmbrellaDBManager dbManager = new UmbrellaDBManager();

        // 3. Validasi user
        String user = dbManager.validateUser(username, password);

        // 4. Jika login berhasil
        if (user != null) {

            // Simpan user login
            UmbrellaApp.loggedInUser = user;

            // Pindah ke halaman utama
            UmbrellaApp.switchScene("umbrella-view.fxml");

        } else {

            // 5. Jika gagal
            lblStatus.setText("AUTHENTICATION FAILED");
        }
    }
}



