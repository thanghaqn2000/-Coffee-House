package com.example.thecoffeehouse.tablayout;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.thecoffeehouse.R;
import com.example.thecoffeehouse.model_adapter.DoUong;
import com.example.thecoffeehouse.model_adapter.SanPhamAdapter;

public class ThucUongFragment extends Fragment {

    private GridView gvmon;
    private SanPhamAdapter spadt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View r = inflater.inflate(R.layout.fragment_pho_bien, container, false);
        gvmon = r.findViewById(R.id.gv_mon);
        spadt = new SanPhamAdapter(ThucUongFragment.this.getActivity(), R.layout.item);
        gvmon.setAdapter(spadt);
        registerForContextMenu(gvmon);
        fakeData();
        addEvents();
        return r;
    }
    private void fakeData() {
        spadt.add(new DoUong(R.drawable.bacsiu, "Bạc xỉu", "45.000"));
        spadt.add(new DoUong(R.drawable.espreso, "ESPRESSO", "67.000"));
        spadt.add(new DoUong(R.drawable.mattchadaxay, "Mattcha đá xay", "50.000"));
        spadt.add(new DoUong(R.drawable.coldbrew, "Cold Brew đá", "45.000"));
        spadt.add(new DoUong(R.drawable.coldbrewsuatuoi, "Cold Brew sữa tươi", "55.000"));
        spadt.add(new DoUong(R.drawable.cafeden, "Cà phê đen", "37.000"));
        spadt.add(new DoUong(R.drawable.mocha, "Mocha", "40.000"));
        spadt.add(new DoUong(R.drawable.luamach, "Cà phê lúa mạch nóng", "55.000"));
    }
    private void addEvents() {
        gvmon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Dialog dialog = new Dialog(ThucUongFragment.this.getActivity());
                dialog.setContentView(R.layout.dilg_dathang);
                dialog.show();
            }
        });
        gvmon.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(ThucUongFragment.this.getActivity());
                dialog.setContentView(R.layout.dhang);
                dialog.show();

                return true;
            }
        });
    }
}