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
public class PetAndBirdFragment extends Fragment {


    public PetAndBirdFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryItemAdapter categoryItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pet_and_bird, container, false);
        categoryRecyclerView = view.findViewById(R.id.pet_and_birds_recycler_view);
        categoryRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        List<CategoryItemModel> categoryItemModelList = new ArrayList<CategoryItemModel>();
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_sagor_mart,"Sagor Mart", "www.facebook.com/SagorMartBD/"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_chaldal,"Chaldal", "chaldal.com/pet-care"));

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
        categoryRecyclerView.addItemDecoration(new PetAndBirdFragment.SpacesItemDecoration(7));
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
