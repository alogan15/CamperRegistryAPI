import React, { useState, useRef } from "react";
import ReactDOM from "react-dom";
import './style.css';
import { Modal, Button, Form } from "react-bootstrap";

function Inventory() {
  const [newListItem, setNewListItem] = useState([]);
  const [show, setShow] = useState(false);
  const input = useRef();
  const changeOpen = () => setShow(true);
  const changeClose = () => setShow(false);

  var addToList = e => {
    e.preventDefault();
    setNewListItem([...newListItem, input.current.value]);
  };

  return (
    <div className="Inventory">
      <h2>What do I need for camp</h2>

      <Button onClick={changeOpen}>Add to the List</Button>

      <Modal show={show} onHide={changeClose}>
        <Modal.Header closeButton>
          <Modal.Title>Close List</Modal.Title>
        </Modal.Header>
        <form onSubmit={addToList}>
          <Modal.Body>
            <Form.Group>
              <Form.Label>Add to List</Form.Label>
              <br />
              <Form.Control type="text" ref={input} placeholder="Normal text" />
            </Form.Group>
          </Modal.Body>
          <Modal.Footer>
            <Button type="sumbit">Submit</Button>
          </Modal.Footer>
        </form>
      </Modal>

      <ul>
        {newListItem.map((item, b) => (
          <li key={b}>{item}</li>
        ))}
      </ul>
    </div>
  );
}

export default Inventory;
