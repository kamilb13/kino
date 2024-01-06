import {useState} from "react";


function NewActorForm(props){

    const [name, setName] = useState('');
    const [lastName, setLastName] = useState('');
    const [born, setBorn] = useState('');
    const [salary, setSalary] = useState('');

    const submitActor = () => {

        const formData = {
            name: name,
            lastName: lastName,
            born: born,
            salary: salary
        };

        setBorn('');
        setSalary('');
        setLastName('');
        setName('');

        fetch('http://localhost:8080/dodaj-aktora', {
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

        window.location.reload();

    };

    return (
        <div>
            <form onSubmit={submitActor}>
                <div>
                    <label className="form-label">Imie</label>
                    <input type="text" className='form-control' onChange={(e) => {setName(e.target.value)}} value={name} name="name" required></input>
                </div>
                <div>
                    <label className="form-label">Nazwisko</label>
                    <input type="text" className='form-control' onChange={(e) => {setLastName(e.target.value)}} value={lastName} name="lastName" required></input>
                </div>
                <div>
                    <label className="form-label">Data urodzenia</label>
                    <input type='date' className='form-control' onChange={(e) => {setBorn(e.target.value)}} value={born} name="born" required></input>
                </div>
                <div>
                    <label className="form-label">Wynagrodzenie</label>
                    <input type="number" className='form-control' onChange={(e) => {setSalary(e.target.value)}} value={salary} name="salary" required></input>
                </div>

                <button type='submit' className="btn btn-primary mt-3">Add Actor</button>
            </form>
        </div>

    );
}

export default NewActorForm;