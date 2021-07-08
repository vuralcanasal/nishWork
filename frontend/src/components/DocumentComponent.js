import React from 'react'
import axios from 'axios'
import { Button } from 'react-bootstrap';


class DocumentComponent extends React.Component{

    constructor(props) {
        super(props)
        this.state = {
            documents:[]
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8070/api/files").then((response) => {
            this.setState({ documents: response.data })
        });
    }
    
    render() {
        return (
            <div>
                <h1 className="text-center"> Dosya Listesi </h1>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Adı</td>
                            <td>Sahibi</td>
                            <td>İşlemler</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.documents.map(
                                document =>
                                    <tr key={document.id}>
                                        <td>{document.id}</td>
                                        <td>{document.name}</td>
                                        <td>{document.customer.name}</td>
                                        <td>
                                            <Button variant="secondary" size="sm">İndir</Button>&nbsp;
                                            <Button variant="secondary" size="sm">Güncelle</Button>&nbsp;
                                            <Button variant="secondary" size="sm">Sil</Button>&nbsp;
                                        </td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>

            </div>
        );
    }
}

export default DocumentComponent