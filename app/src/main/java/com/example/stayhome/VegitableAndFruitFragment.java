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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class VegitableAndFruitFragment extends Fragment {


    public VegitableAndFruitFragment() {
        // Required empty public constructor
    }
    private RecyclerView categoryRecyclerView;
    private CategoryItemAdapter categoryItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_vegitable_and_fruit, container, false);
        categoryRecyclerView = view.findViewById(R.id.vegetable_and_fruit_recycler_view);
        categoryRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        List<CategoryItemModel> categoryItemModelList = new ArrayList<CategoryItemModel>();
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_deshi_bazar,"deshibazar", "www.deshibazar.shop/product-category/fruits-and-vegetables"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_mudiman,"Mudiman Vegetable", "www.mudiman.com/shop/vegetables"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_mudiman,"Mudiman Fruit", "www.mudiman.com/shop/fruits"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_frame_fresh_organic,"farmfreshorganics", "www.farmfreshorganics.com.bd"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_parmeeda,"parmeeda Fruit", "www.parmeeda.com"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_taja_fol,"TazaFol", "https://www.facebook.com/TazaFol.BD/"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_arham,"Aarham's daily", "www.facebook.com/photo/?fbid=109549584031843&set=a.108698627450272"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_basar_bazar,"Bashar Bazar", "www.basarbazar.com.bd"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_royal_fruit,"RoyalFruit", "www.facebook.com/royalFruitz"));

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
        categoryRecyclerView.addItemDecoration(new VegitableAndFruitFragment.SpacesItemDecoration(7));
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
