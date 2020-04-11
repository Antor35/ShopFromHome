package com.example.stayhome;


import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GlossaryFragment extends Fragment {


    public GlossaryFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryItemAdapter categoryItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_glossary, container, false);
       categoryRecyclerView = view.findViewById(R.id.glossary_recycler_view);
       categoryRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        List<CategoryItemModel> categoryItemModelList = new ArrayList<CategoryItemModel>();
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_shwapno,"Showpnoo", "www.shwapno.com"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_meenabazar,"Meena Bazar", "www.meenaclick.com"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_khass_food,"Khass Food", "www.khaasfood.com"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_othoba,"Othoba", "www.othoba.com/"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_evaly,"evaly", "www.evaly.com.bd"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_daraz,"Daraz", "www.daraz.com.bd"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_priyo_shop,"Priyo Shop", "www.priyoshop.com"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_ajker_deal,"Ajker Deal", "www.ajkerdeal.com/category/essentials"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_bikroy_dot_com,"Bikry.com", "www.bikroy.com/en/ads/bangladesh/essentials"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_e_fresh_store,"eFreshStore", "www.e-freshstore.com"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_amader_baxar,"Amader Bazar", "www.amaderbazarbd.com"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_deshi_bazar,"Deshi Bazar", "www.deshibazar.shop"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_my_organic,"My organic BD", "www.myorganicbd.com"));

        categoryItemAdapter = new CategoryItemAdapter(categoryItemModelList, new OnItemClickListener() {
            @Override
            public void onItemClick(CategoryItemModel item) {
                //Toast.makeText(getActivity(),""+item.getShopName(),Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                bundle.putString("shopAddress", item.getShopAddress());
                Intent intent = new Intent(getActivity(),ShopActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        categoryRecyclerView.addItemDecoration(new SpacesItemDecoration(7));
        categoryRecyclerView.setAdapter(categoryItemAdapter);
        categoryItemAdapter.notifyDataSetChanged();


       return view;
    }


    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.top = space;
            } else {
                outRect.top = 0;
            }
        }
    }

}
