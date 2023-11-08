import { useEffect, useState } from "react"
import { fetchtipogrupo } from "../../api/dataService"
import 'devextreme/data/odata/store';
import DataGrid, { Column } from 'devextreme-react/data-grid';


export default function Tipogrupo() {
    // Se declara un estado llamado 'groupsWithPersonCount' utilizando useState.
    const [groupsWithPersonCount, setGroupsWithPersonCount] = useState();
  
    // Utiliza useEffect para realizar la solicitud a la API cuando el componente se monta.
    useEffect(() => {
      fetchtipogrupo()
        .then((response) => {
          // Extrae los datos de respuesta de la solicitud.
          const groupsData = response.data;
  
          // Registra los datos de grupos en la consola.
          console.log(groupsData);
  
          // Modifica el estado 'groupsWithPersonCount' transformando los datos de grupos.
          setGroupsWithPersonCount(groupsData.map(tipogrupo=> ({
            id: tipogrupo.id,
            tipo:tipogrupo.tipo,
           
          })))
        })
        .catch((error) => {
          console.log(error);
        })
    }, []); // El [] como segundo argumento asegura que useEffect se ejecute solo una vez al montar el componente.
  
    return (
        <DataGrid
          // Establece la fuente de datos para el DataGrid como 'groupsWithPersonCount'.
          dataSource={groupsWithPersonCount}
          
          // Muestra bordes alrededor de las celdas de la tabla.
          showBorders={true}
        >
          {/* Define la primera columna con el campo 'id' y un ancho de 50 píxeles. */}
          <Column dataField="id" width={50} />
          
          {/* Define la segunda columna con el campo 'name'. */}
          <Column dataField="tipo" />
        
        </DataGrid>
  
    )
  }

