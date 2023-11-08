import { useEffect, useState } from "react";
import { fetchpersons } from "../../api/dataService";
import 'devextreme/data/odata/store';
import DataGrid, { Column } from 'devextreme-react/data-grid';

export default function Persons() {
  // Se declara un estado llamado 'personssWithPersonCount' utilizando useState.
  const [personssWithPersonCount, setPersonssWithPersonCount] = useState([]);

  // Utiliza useEffect para realizar la solicitud a la API cuando el componente se monta.
  useEffect(() => {
    fetchpersons()
      .then((response) => {
        // Extrae los datos de respuesta de la solicitud.
        const personsData = response.data;

        // Registra los datos de grupos en la consola.
        console.log(personsData);

        // Modifica el estado 'personssWithPersonCount' transformando los datos de grupos.
        setPersonssWithPersonCount(personsData.map(person => ({
          id: person.id,
          name: person.name
        })));
      })
      .catch((error) => {
        console.log(error);
      })
  }, []); // El [] como segundo argumento asegura que useEffect se ejecute solo una vez al montar el componente.

  return (
      <DataGrid
        // Establece la fuente de datos para el DataGrid como 'personssWithPersonCount'.
        dataSource={personssWithPersonCount}
        
        // Muestra bordes alrededor de las celdas de la tabla.
        showBorders={true}
      >
        {/* Define la primera columna con el campo 'id' y un ancho de 50 píxeles. */}
        <Column dataField="id" width={50} />
        
        {/* Define la segunda columna con el campo 'name'. */}
        <Column dataField="name" />
      </DataGrid>
  )
}
