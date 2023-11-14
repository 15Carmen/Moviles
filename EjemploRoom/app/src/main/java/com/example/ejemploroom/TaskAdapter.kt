package com.example.ejemploroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemploroom.entidades.TaskEntity

class TasksAdapter(
    val tasks: List<TaskEntity>,                   // Objeto Lista de tareas
    val checkTask: (TaskEntity) -> Unit,            // chequeo de tarea
    val deleteTask: (TaskEntity) -> Unit            // borrado de tarea
) : RecyclerView.Adapter<TasksAdapter.ViewHolder>() {    // Devuelve la vista


    // Muestra la vista (holder) y cada tarea de la lista (position)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Extrae la tarea de la lista
        val item = tasks[position]

        // Muestra el item en la vista (ver más adelante)
        holder.bind(item, checkTask, deleteTask)
    }

    // Contenedor de la vista (holder) y la posición de la tarea en la lista (position)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // Se instancia el Layout para la vista
        val layoutInflater = LayoutInflater.from(parent.context)

        // Devuelve la vista inflando el layout del item
        return ViewHolder(layoutInflater.inflate(R.layout.item_task, parent, false)
        )
    }

    override fun getItemCount(): Int {
        // Devuelve el número de tareas de la lista
        return tasks.size
    }

    // Clase con la vista
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // instancia del Textview de la vista
        val tvTask = view.findViewById<TextView>(R.id.tvTask)

        // instancia del Checkbox de la vista
        val cbIsDone = view.findViewById<CheckBox>(R.id.cbIsDone)

        // función que une los elementos en la vista y prepara los listeners
        fun bind(
            task: TaskEntity,
            checkTask: (TaskEntity) -> Unit,
            deleteTask: (TaskEntity) -> Unit
        ) {
            tvTask.text = task.name
            cbIsDone.isChecked = task.isDone
            cbIsDone.setOnClickListener { checkTask(task) }
            itemView.setOnClickListener { deleteTask(task) }
        }
    }
}