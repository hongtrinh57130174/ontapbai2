package vn.edu.ntu.ontapbai2.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.ontapbai2.model.contact;

public class Controller extends Application implements Icartcontroller {

    List<contact> contactList;

    public Controller() {
        contactList = new ArrayList<>();
        contactList.add(new contact(1,"Tô Phước Thái","09/09/1998","1977861876","Việt Nam"));
        contactList.add(new contact(2,"Thúy Hồng","09/10/1998","1977861276","Việt Nam"));
        contactList.add(new contact(3,"Thái Tuấn","11/09/1998","1977861776","Việt Nam"));
    }

    @Override
    public List<contact> GetAllContact() {
        return contactList;
    }

    @Override
    public void addcontact(contact p) {
        contactList.add(p);
    }

    @Override
    public void editcontact(int id, contact contact) {
        for(contact p: contactList)
        {
            if(p.getId() == id)
            {
                p.setName(contact.getName());
                p.setAddress(contact.getAddress());
                p.setBirthday(contact.getBirthday());
                p.setPhone(contact.getPhone());
            }
        }
    }
}
