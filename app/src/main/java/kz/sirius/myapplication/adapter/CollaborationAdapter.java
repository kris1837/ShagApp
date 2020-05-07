package kz.sirius.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import kz.sirius.myapplication.R;
import kz.sirius.myapplication.entity.AlibisEntity;
import kz.sirius.myapplication.entity.AmirkhanItem;
import kz.sirius.myapplication.entity.Drink;
import kz.sirius.myapplication.entity.EntityYernar;
import kz.sirius.myapplication.entity.LevsItem;
import kz.sirius.myapplication.entity.VadimItem;
import kz.sirius.myapplication.entity.VladItem;
import kz.sirius.myapplication.viewHolders.AlibisViewHolder;
import kz.sirius.myapplication.viewHolders.AmirkhansViewHolder;
import kz.sirius.myapplication.viewHolders.DrinkViewHolder;
import kz.sirius.myapplication.viewHolders.LevsViewHolder;
import kz.sirius.myapplication.viewHolders.VadimsViewHolder;
import kz.sirius.myapplication.viewHolders.ViewHolderYernar;
import kz.sirius.myapplication.viewHolders.VladViewHolder;

public class CollaborationAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VLAD_VIEW_TYPE = 0;
    private static final int DRINK_VIEW_TYPE = 2;
    private static final int DEFAULT = 1;
    private static final int ALIBI_VIEW_TYPE = 3;
    private static final int YERNAR_VIEW_TYPE = 4;
    private static final int LEV_VIEW_TYPE = 5;
    private static final int VADIM_VIEW_TYPE = 6;
    private static final int AMIRHAN_VIEW_TYPE = 7;

    private OnCollaborationClickListener listener;

    private ArrayList<Object> items = new ArrayList<>();

    public CollaborationAdapter(OnCollaborationClickListener listener) {
        this.listener = listener;
    }

    public void setItems(ArrayList<Object> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof VladItem) {
            return VLAD_VIEW_TYPE;
        } else if (items.get(position) instanceof Drink) {
            return DRINK_VIEW_TYPE;
        } else if (items.get(position) instanceof AlibisEntity) {
            return ALIBI_VIEW_TYPE;
        } else if (items.get(position) instanceof EntityYernar) {
            return YERNAR_VIEW_TYPE;
        } else if (items.get(position) instanceof LevsItem) {
            return LEV_VIEW_TYPE;
        } else if (items.get(position) instanceof VadimItem) {
            return VADIM_VIEW_TYPE;
        } else if (items.get(position) instanceof AmirkhanItem) {
            return AMIRHAN_VIEW_TYPE;
        } else {
            return DEFAULT;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VLAD_VIEW_TYPE) {
            return new VladViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.holder_vlad,
                    parent,
                    false));
        } else if (viewType == DRINK_VIEW_TYPE) {
            return new DrinkViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.holder_drink,
                    parent,
                    false));
        } else if (viewType == ALIBI_VIEW_TYPE) {
            return new AlibisViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.holder_alibi,
                    parent,
                    false));
        } else if (viewType == YERNAR_VIEW_TYPE)  {
            return new ViewHolderYernar(LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_layout_yernar,
                    parent,
                    false));
        } else if (viewType == LEV_VIEW_TYPE) {
            return new LevsViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.holder_lev,
                    parent,
                    false));
        } else if (viewType == VADIM_VIEW_TYPE) {
            return new VadimsViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.holder_vadim,
                    parent,
                    false));
        } else if (viewType == AMIRHAN_VIEW_TYPE) {
            return new AmirkhansViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.holder_amirkhan,
                    parent,
                    false));
        } else {
            return new MyRecyclerAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.holder_vlad,
                    parent,
                    false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VladViewHolder) {
            if (items.get(position) instanceof VladItem) {
                ((VladViewHolder) holder).bind((VladItem) items.get(position));
            }
        } else if (holder instanceof DrinkViewHolder) {
            ((DrinkViewHolder) holder).bind((Drink) items.get(position));
        } else if (holder instanceof AlibisViewHolder) {
            ((AlibisViewHolder) holder).bind((AlibisEntity) items.get(position));
        } else if (holder instanceof ViewHolderYernar) {
            ((ViewHolderYernar) holder).bind((EntityYernar) items.get(position));
        } else if (holder instanceof  LevsViewHolder) {
            ((LevsViewHolder) holder).bind((LevsItem) items.get(position));
        } else if (holder instanceof VadimsViewHolder) {
            ((VadimsViewHolder) holder).bind((VadimItem) items.get(position));
        } else if (holder instanceof AmirkhansViewHolder) {
            ((AmirkhansViewHolder) holder).bind((AmirkhanItem) items.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
