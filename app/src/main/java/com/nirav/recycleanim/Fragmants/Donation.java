package com.nirav.recycleanim.Fragmants;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nirav.recycleanim.Beans.List_Beans;
import com.nirav.recycleanim.MainActivity;
import com.nirav.recycleanim.MyAdapter;
import com.nirav.recycleanim.R;
import com.tbuonomo.materialsquareloading.MaterialSquareLoading;
import com.zach.salman.springylib.springyRecyclerView.SpringyAdapterAnimationType;
import com.zach.salman.springylib.springyRecyclerView.SpringyAdapterAnimator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer on 21-09-2016.
 */
public class Donation extends Fragment {

    View view;

    RecyclerView recyclerView;
    String url = "https://content.guardianapis.com/search?q=trump&api-key=test";
    RecyclerView.Adapter adapter;
    List<List_Beans> listItems;
   // MaterialSquareLoading materialSquareLoading;

    public Donation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.donation, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

      //  materialSquareLoading = (MaterialSquareLoading)view.findViewById(R.id.material_square_loading_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listItems = new ArrayList<>();
        loadRecycleView();
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Donation");

        // Inflate the layout for this fragment
        return view;
    }

    public void loadRecycleView() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading data");
        progressDialog.show();

      //  materialSquareLoading.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
               // materialSquareLoading.hide();
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String syncresponse = jsonObject.getString("response");
                    JSONObject object2 = new JSONObject(syncresponse);

                    JSONArray jsonArray = object2.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject o = jsonArray.getJSONObject(i);

                        List_Beans dataSet = new List_Beans();


                        dataSet.setWebTitle(o.getString("webTitle"));
                        dataSet.setIsHosted(o.getString("isHosted"));
                        dataSet.setSectionId(o.getString("sectionId"));
                        dataSet.setSectionName(o.getString("sectionName"));
                        dataSet.setType(o.getString("type"));

                        listItems.add(dataSet);
                    }
                    adapter = new MyAdapter(listItems, getActivity(),recyclerView);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                //materialSquareLoading.hide();
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);


    }
}