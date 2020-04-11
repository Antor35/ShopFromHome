package com.example.stayhome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryItemAdapter extends RecyclerView.Adapter<CategoryItemAdapter.ViewHolder> {

    private List<CategoryItemModel> categoryItemModelList;
    private final OnItemClickListener listener;

    public CategoryItemAdapter(List<CategoryItemModel> categoryItemModelList, OnItemClickListener listener) {
        this.categoryItemModelList = categoryItemModelList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        view.setElevation(0);
        view.setPadding(5,5,5,5);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemAdapter.ViewHolder holder, int position) {
        int logopath = categoryItemModelList.get(position).getShopLogo();
        String  name = categoryItemModelList.get(position).getShopName();
        holder.setShoplogo(logopath);
        holder.bind(categoryItemModelList.get(position), listener);
        holder.setShopName(name);
    }

    @Override
    public int getItemCount() {
        return categoryItemModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView shoplogo;
        private View divider;
        private TextView shopName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shoplogo = itemView.findViewById(R.id.shop_logo);
            divider = itemView.findViewById(R.id.divider);
            shopName = itemView.findViewById(R.id.shop_title);
        }

        public void bind(final CategoryItemModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }

        private  void setShoplogo(int logoPath){
            shoplogo.setImageResource(logoPath);
        }
        private void  setShopName(String name){
            shopName.setText(name);
        }
    }
}
