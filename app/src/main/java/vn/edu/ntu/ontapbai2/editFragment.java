package vn.edu.ntu.ontapbai2;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

import vn.edu.ntu.ontapbai2.controller.Icartcontroller;
import vn.edu.ntu.ontapbai2.model.contact;

public class editFragment extends Fragment {

    Toolbar toolbar;
    EditText edtID, edtName, edtPhone, edtAddress, edtBirth;
    Button btnsave;
    ImageView imgback;

    List<contact> contactList;

    contact contact;

    Icartcontroller controller;
    NavController navController;

    int id, edit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        addview(view);
        gettoolbar();
        getdata();
        addevent();
        return view;
    }

    private void addview(View view) {
        edtID = view.findViewById(R.id.edtid);
        edtName = view.findViewById(R.id.edtname);
        edtBirth = view.findViewById(R.id.edtbirth);
        edtPhone = view.findViewById(R.id.edtphone);
        edtAddress = view.findViewById(R.id.edtaddress);
        btnsave = view.findViewById(R.id.btnsave);
        imgback = view.findViewById(R.id.imgback);

        controller = ((MainActivity)getActivity()).controller;
        navController = NavHostFragment.findNavController(editFragment.this);

    }

    private void gettoolbar() {
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_editFragment_to_danhsachFragment);
            }
        });
    }

    private void getdata() {
        contactList = controller.GetAllContact();
        Bundle data = getArguments();
        edit = data.getInt("edit");
        id = data.getInt("ID");
        if(edit == -1)
        {
            edtID.setText(String.valueOf(id));
        }
        else
        {
            for(contact p: contactList)
            {
                if(p.getId() == edit)
                {
                    edtID.setText(String.valueOf(edit));
                    edtName.setText(p.getName());
                    edtBirth.setText(p.getBirthday());
                    edtPhone.setText(p.getPhone());
                    edtAddress.setText(p.getAddress());
                }
            }
        }
    }

    private void addevent() {
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edit == -1) {
                    contact = new contact(id, edtName.getText().toString(), edtBirth.getText().toString(), edtPhone.getText().toString()
                            , edtAddress.getText().toString());
                    controller.addcontact(contact);
                    navController.navigate(R.id.action_editFragment_to_danhsachFragment);
                }
                else
                {
                    contact = new contact(edit, edtName.getText().toString(), edtBirth.getText().toString(), edtPhone.getText().toString()
                            , edtAddress.getText().toString());
                    controller.editcontact(edit,contact);
                }
            }
        });
    }
}