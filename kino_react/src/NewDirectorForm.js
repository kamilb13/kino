import React, {useState} from "react";

function NewDirectorForm(){

    const [name, setName] = useState('');
    const [lastName, setLastName] = useState('');
    const [born, setBorn] = useState('');

    const submitDirector = () => {


        const formData = {
            name: name,
            lastName: lastName,
            born: born,
        };

        setName('');
        setLastName('');
        setBorn('');

        fetch('http://localhost:8080/dodaj-rezysera', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
            },
            body: JSON.stringify(formData),

        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            }).then(data => {
            console.log('Success:', data);
        })
            .catch(error => {
                console.error('Error:', error);
            });

        //window.location.reload();

    };

    return (
        <div className="mt-5">
            <form onSubmit={submitDirector} id="Form">

                <div className="mb-3">
                    <label className="form-label">Imie</label>
                    <input
                        type="text"
                        className="form-control"
                        required
                        onChange={(e) => setName(e.target.value)}
                        value={name}
                        name="name"
                    ></input>
                </div>
                <div className="mb-3">
                    <label className="form-label">Nazwisko</label>
                    <input
                        type='text'
                        className='form-control'
                        rows={3}
                        required
                        onChange={(e) => setLastName(e.target.value)}
                        value={lastName}
                        name="lastName"
                    ></input>
                </div>
                <div className="mb-3">
                    <label className="form-label">Data urodzenia</label>
                    <input
                        type="date"
                        className='form-control'
                        rows={3}
                        required
                        onChange={(e) => setBorn(e.target.value)}
                        value={born}
                        name="born"
                    ></input>

                </div>

                <button
                    type="submit"
                    className="btn btn-primary mt-3"
                >
                    Add Director
                </button>
            </form>
        </div>
    );
}

export default NewDirectorForm;