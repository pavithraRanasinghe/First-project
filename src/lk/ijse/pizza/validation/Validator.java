/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.validation;

import javax.swing.JTextField;

/**
 *
 * @author Pavithra
 */
public class Validator {

    public static boolean nicValidation(JTextField nicTextField) {

        String text = nicTextField.getText();
        int caretPosition = nicTextField.getCaretPosition();
        if (text.matches("[0-9]{9}[vV]")) {
            return true;
        } else {

            return false;
        }

    }

    public static boolean emailValidation(JTextField emailTextField) {
        String text = emailTextField.getText();
        if (text.matches("[a-z]+[@][a-z]+[.][a-z]+") || text.matches("")) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean telephoneValidation(JTextField txtTele) {
        String tele = txtTele.getText();
        if (tele.matches("[0-9]{3}[-][0-9]{7}") || tele.matches("")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean priceText(JTextField textField) {
        String text = textField.getText();
        boolean res = text.matches("[0-9]+[.]?[0-9]{0,2}");
        if (res) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean name(JTextField textField) {
        System.out.println("Name textfield : " + textField);
        String txt = textField.getText();
        int caretPosition = textField.getCaretPosition();
        if (txt.matches("^[A-Za-z// ]*$")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numberOnly(JTextField textField) {
        String txt = textField.getText();
        int caretPosition = textField.getCaretPosition();
        if (txt.matches("^[\\d]*")) {
            return true;
        } else {
            return false;
        }
    }
}
