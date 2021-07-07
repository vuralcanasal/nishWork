import React from 'react'
import axios from 'axios'
import { Button } from 'react-bootstrap';


class CustomerComponent extends React.Component{

    constructor(props) {
        super(props)
        this.state = {
            customers:[]
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8070/api/customers").then((response) => {
            this.setState({ customers: response.data })
        });
    }
    
    render() {
        return (
            <div>
                <h1 className="text-center"> Müsteri Listesi </h1>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Adı</td>
                            <td>Soyadı</td>
                            <td>E-mail Adresi</td>
                            <td>İşlemler</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.customers.map(
                                customer =>
                                    <tr key={customer.id}>
                                        <td>{customer.id}</td>
                                        <td>{customer.name}</td>
                                        <td>{customer.surname}</td>
                                        <td>{customer.email}</td>
                                        <td>
                                            <Button variant="secondary" size="sm">Dosyalar</Button>&nbsp;
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

export default CustomerComponent