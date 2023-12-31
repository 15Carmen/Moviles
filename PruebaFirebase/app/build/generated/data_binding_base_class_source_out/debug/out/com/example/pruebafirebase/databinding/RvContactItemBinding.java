// Generated by view binder compiler. Do not edit!
package com.example.pruebafirebase.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.pruebafirebase.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RvContactItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView fotoContacto;

  @NonNull
  public final TextView idContaco;

  @NonNull
  public final TextView nombre;

  @NonNull
  public final TextView telefono;

  private RvContactItemBinding(@NonNull LinearLayout rootView, @NonNull ImageView fotoContacto,
      @NonNull TextView idContaco, @NonNull TextView nombre, @NonNull TextView telefono) {
    this.rootView = rootView;
    this.fotoContacto = fotoContacto;
    this.idContaco = idContaco;
    this.nombre = nombre;
    this.telefono = telefono;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RvContactItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RvContactItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.rv_contact_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RvContactItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.fotoContacto;
      ImageView fotoContacto = ViewBindings.findChildViewById(rootView, id);
      if (fotoContacto == null) {
        break missingId;
      }

      id = R.id.idContaco;
      TextView idContaco = ViewBindings.findChildViewById(rootView, id);
      if (idContaco == null) {
        break missingId;
      }

      id = R.id.nombre;
      TextView nombre = ViewBindings.findChildViewById(rootView, id);
      if (nombre == null) {
        break missingId;
      }

      id = R.id.telefono;
      TextView telefono = ViewBindings.findChildViewById(rootView, id);
      if (telefono == null) {
        break missingId;
      }

      return new RvContactItemBinding((LinearLayout) rootView, fotoContacto, idContaco, nombre,
          telefono);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
