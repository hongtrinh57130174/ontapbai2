package vn.edu.ntu.ontapbai2.controller;

import java.util.List;

import vn.edu.ntu.ontapbai2.model.contact;

public interface Icartcontroller {
    public List<contact> GetAllContact();
    public void addcontact(contact p);
    public void editcontact(int id, contact p);
}
