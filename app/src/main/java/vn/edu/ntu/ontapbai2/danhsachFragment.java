package vn.edu.ntu.ontapbai2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.ntu.ontapbai2.controller.Icartcontroller;
import vn.edu.ntu.ontapbai2.model.contact;

public class danhsachFragment extends Fragment {

    Toolbar toolbar;
    RecyclerView recyclerView;

    NavController navController;
    Icartcontroller controller;

    List<contact> contactList;

    Bundle data = new Bundle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_danhsach, container, false);
        addview(view);
        gettoolbar();
        getdata();
        return view;
    }

    private void addview(View view) {
        toolbar = view.findViewById(R.id.toolbards);
        recyclerView = view.findViewById(R.id.recycleview);

        controller = ((MainActivity) getActivity()).controller;
        navController = NavHostFragment.findNavController(danhsachFragment.this);
    }

    private void gettoolbar() {
        toolbar.inflateMenu(R.menu.my_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                data.putInt("ID", contactList.size() + 1);
                data.putInt("edit",-1);
                navController.navigate(R.id.action_danhsachFragment_to_editFragment,data);
                return false;
            }
        });
    }

    private void getdata() {
        contactList = controller.GetAllContact();

       recyclerView.setLayoutManager(new LinearLayoutManager(danhsachFragment.this.getActivity()));
       ContactAdapter adapter;
        adapter = new ContactAdapter(contactList);
        recyclerView.setAdapter(adapter);
    }

    private class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView txtten, txtngaysinh, txtsdt;
        ImageView imgedit;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            txtten = itemView.findViewById(R.id.txtten);
            txtngaysinh = itemView.findViewById(R.id.txtngaysinh);
            txtsdt = itemView.findViewById(R.id.txtsdt);
            imgedit = itemView.findViewById(R.id.imgedit);
        }

        public void bind(contact p) {
            txtten.setText(p.getName());
            txtsdt.setText(p.getPhone());
            txtngaysinh.setText(p.getBirthday());
        }
    }

    private class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
        List<contact> listContacts;
        //danh sach cac phan tu can truyen vao viewholder

        public ContactAdapter(List<contact> listContact) {
            this.listContacts = listContact;
        }


        @NonNull
        @Override
        public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.contact, parent, false);
            return new ContactViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull danhsachFragment.ContactViewHolder holder, final int position) {
            holder.bind(listContacts.get(position));

            holder.imgedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data.putInt("edit", listContacts.get(position).getId());
                    navController.navigate(R.id.action_danhsachFragment_to_editFragment,data);
                }
            });
        }

        @Override
        public int getItemCount() {
            return listContacts.size();
        }
    }
}