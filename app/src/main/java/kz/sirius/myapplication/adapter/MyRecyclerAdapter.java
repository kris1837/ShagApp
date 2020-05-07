package kz.sirius.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import kz.sirius.myapplication.entity.LevsItem;
import kz.sirius.myapplication.R;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{

    private ArrayList<LevsItem> items = new ArrayList<>();

    public void setContent(ArrayList<LevsItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_my_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.uiText.setText(items.get(position).getTitle());
        holder.uiTextDetails.setText(items.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView uiText;
        TextView uiTextDetails;
        public MyViewHolder(View v) {
            super(v);
            uiText = v.findViewById(R.id.uiText);
            uiTextDetails = v.findViewById(R.id.uiTextDetails);
        }
    }
}

