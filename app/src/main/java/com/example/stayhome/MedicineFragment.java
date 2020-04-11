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
public class MedicineFragment extends Fragment {


    public MedicineFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryItemAdapter categoryItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medicine, container, false);

        categoryRecyclerView = view.findViewById(R.id.medicine_recycler_view);
        categoryRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        List<CategoryItemModel> categoryItemModelList = new ArrayList<CategoryItemModel>();
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_laz_pharma,"lazzpharma", "www.lazzpharma.com"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_pharmacy_bd,"pharmacy", "www.pharmacy.com.bd"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_bangla_meds,"banglameds", "www.banglameds.com.bd"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_khidmat,"khidmatdrug", "www.khidmatdrug.online"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_epharma,"epharma", "www.epharma.com.bd"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_osudh,"ousud", "www.ousud.com"));
        categoryItemModelList.add(new CategoryItemModel(R.drawable.logo_osudhola,"oshudhwala", "www.oshudhwala.com"));

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
        categoryRecyclerView.addItemDecoration(new MedicineFragment.SpacesItemDecoration(7));
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
