package com.prasannakc.dissertation;

/**
 * Created by PrasannaKC on 29/04/2015.
 */
public class Users {

    private String _username, _password, _email;

    private int _id;

    public Users(int id, String username, String password, String email) {
        this._id = id;
        this._username = username;
        this._password = password;
        this._email = email;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }
}
