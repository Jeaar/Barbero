package com.example.barbero


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbero.databinding.ItemPurchaseBinding

class PurchaseAdapter(private var purchases: List<Purchase>) :
    RecyclerView.Adapter<PurchaseAdapter.PurchaseViewHolder>() {

    class PurchaseViewHolder(val binding: ItemPurchaseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(purchase: Purchase) {
            binding.serviceText.text = purchase.service
            binding.serviceTypeText.text = purchase.serviceType
            binding.dateText.text = purchase.date
            binding.timeText.text = purchase.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseViewHolder {
        val binding =
            ItemPurchaseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PurchaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        holder.bind(purchases[position])
    }

    override fun getItemCount(): Int = purchases.size

    fun updateData(newPurchases: List<Purchase>) {
        purchases = newPurchases
        notifyDataSetChanged()
    }
}
