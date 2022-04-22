package PAT.proyectoFinal.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table("USUARIO")
public class usuarioModel {

  private @Column("USERNAME") @Id
  String username;
  private @Column("NOMBRE")
  String nombre;
  private @Column("APELLIDO")
  String apellido;
  private @Column("EMAIL")
  String email;
  private @Column("EDAD")
  int edad;
  private @Column("PASSWORD")
  String password;
}
