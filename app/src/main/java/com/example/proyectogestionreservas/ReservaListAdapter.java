package com.example.proyectogestionreservas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.proyectogestionreservas.data.entities.Reserva;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReservaListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Reserva reserva);
    }

    private final OnItemClickListener listener;
    private List<Reserva> reservas;

    public ReservaListAdapter(OnItemClickListener listener) {
        this.reservas=new ArrayList<Reserva>();
        this.listener=listener;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.reserva_frame_card;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
        return new RecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Reserva reserva = reservas.get(position);
        RecyclerViewViewHolder viewHolder=(RecyclerViewViewHolder) holder;
        viewHolder.getTextTitle().setText("Habitacion Reservada");
        viewHolder.getTextIdReserva().setText("#"+reserva.getIdReserva());
        viewHolder.getTextTitleHabi().setText("Habitacion Mediana");
        viewHolder.getTextHabiNum().setText("#"+reserva.getIdHabitacion());
        viewHolder.getDescripcion().setText(reserva.getObservaciones());
        viewHolder.getTitleDateEntrada().setText("Fecha Entrada:");
        viewHolder.getTitleDateSalida().setText("Fecha Salida:");
        viewHolder.getTextDateEntrada().setText(reserva.getFechaEntrada());
        viewHolder.getTextDateSalida().setText(reserva.getFechaSalida());
        viewHolder.bind(reserva, listener);
    }

    @Override
    public int getItemCount() {
        return reservas.size();
    }

    public void actualizarListaUsuarioReserva(final List<Reserva> reservaListado){
        this.reservas.clear();
        this.reservas=reservaListado;
        notifyDataSetChanged();
    }

    static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView descripcion,textDateEntrada,textDateSalida,textTitle,
                textTitleDateEntrada,textTitleDateSalida,textTitleHabi,textHabiNum,textIdReserva;
        ScrollView mostrarScroll;
        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            mostrarScroll=itemView.findViewById(R.id.mostrar_scroll);
            textTitle=itemView.findViewById(R.id.textTitleReserva);
            textIdReserva=itemView.findViewById(R.id.textTIdReserva);
            textTitleHabi=itemView.findViewById(R.id.textNumTitleHabi);
            textHabiNum=itemView.findViewById(R.id.textNumHabi);
            descripcion = itemView.findViewById(R.id.textDescHabi);
            textTitleDateEntrada=itemView.findViewById(R.id.textFechaTitleEntrada);
            textTitleDateSalida=itemView.findViewById(R.id.textFechaTitleSalida);
            textDateEntrada=itemView.findViewById(R.id.textFechaTitleEntradaResult);
            textDateSalida=itemView.findViewById(R.id.textFechaTitleSalidaResult);
        }
        public void bind(final Reserva reserva, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(reserva);
                }
            });
        }
        public TextView getTextTitle(){
            return textTitle;
        }
        public TextView getTextIdReserva(){
            return textIdReserva;
        }
        public TextView getTextTitleHabi(){return textTitleHabi;}
        public TextView getTextHabiNum(){return textHabiNum;}
        public TextView getDescripcion(){
            return descripcion;
        }
        public TextView getTitleDateEntrada(){
            return textTitleDateEntrada;
        }
        public TextView getTitleDateSalida(){
            return textTitleDateSalida;
        }
        public TextView getTextDateEntrada(){return textDateEntrada;}
        public TextView getTextDateSalida(){return textDateSalida;}
    }
}
