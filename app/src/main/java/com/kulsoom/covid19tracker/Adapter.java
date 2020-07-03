 package com.kulsoom.covid19tracker;

 import android.content.Context;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.TextView;


 import androidx.annotation.NonNull;
 import androidx.recyclerview.widget.RecyclerView;

 public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
 private Summary summary;
 private Context context;

     public Adapter(Summary summary, Context context) {
         this.summary = summary;
         this.context = context;
     }

     @NonNull
     @Override
     public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.item_holder,parent,false);
         return new ViewHolder(view);
     }

     @Override
     public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
         holder.tvCountryName.setText(summary.getCountries().get(position).getCountry());
         holder.tvTotalCases.setText(summary.getCountries().get(position).getTotalCases());
         holder.tvNewCases.setText(summary.getCountries().get(position).getNewCases());

     }

     @Override
     public int getItemCount() {
         return summary.getCountries().size();
     }

     public class ViewHolder extends RecyclerView.ViewHolder{
         TextView tvCountryName,tvTotalCases,tvNewCases;

         public ViewHolder(@NonNull View itemView) {
             super(itemView);

             tvCountryName = itemView.findViewById(R.id.tvCountryName);
             tvTotalCases = itemView.findViewById(R.id.tvNoTotalCases);
             tvNewCases = itemView.findViewById(R.id.tvNoNewCases);
         }
     }
}
