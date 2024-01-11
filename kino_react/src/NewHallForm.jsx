import {useState} from "react";

function NewHallForm(props){

    const [name, setName] = useState('');
    const [seatsNumber, setSetsNumber] = useState('');
    const [entryNumber, setEntryNumber] = useState('');


    const submitHall = () => {

        const formData = {
            name: name,
            seats_number: seatsNumber,
            entry_number: entryNumber
        }

        setName('');
        setSetsNumber('');
        setEntryNumber('');

        fetch('http://localhost:8080/dodaj-sale', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(formData)
        })
            .then(response => {
                if(!response.ok) {
                    throw new Error('Network response was not ok');
                }

                return response.json();
            }).then(data => {
            console.log('Success:', data);
        })
            .catch(error => {
                console.error('Error:', error);
            });

        console.log(formData);

        window.location.reload();



    };

    return (
        <div>
            <form onSubmit={submitHall}>
                <div>
                    <label className="form-label">Nazwa</label>
                    <input type="text" className='form-control' onChange={(e) => {setName(e.target.value)}} value={name} name="name" required></input>
                </div>
                <div>
                    <label className="form-label">Ilosc Miejsc</label>
                    <input type="number" className='form-control' onChange={(e) => {setSetsNumber(e.target.value)}} value={seatsNumber} name="seats_number" required></input>
                </div>
                <div>
                    <label className="form-label">Ilosc Wejsc</label>
                    <input type='number' className='form-control' onChange={(e) => {setEntryNumber(e.target.value)}} value={entryNumber} name="entry_number" required></input>
                </div>

                <button type='submit' className="btn btn-primary mt-3">Add Hall</button>
            </form>

        </div>
    );

}


export default NewHallForm;