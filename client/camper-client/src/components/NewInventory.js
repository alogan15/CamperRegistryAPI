import React, { useState, useRef } from "react";
import './style.css';
import Typography from "@mui/material/Typography";
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Modal from '@mui/material/Modal';
import { TextField } from "@mui/material";
import Stack from "@mui/material/Stack";

function NewInventory() {
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const [newListItem, setNewListItem] = useState([]);
//   const [show, setShow] = useState(false);
  const input = useRef();
//   const changeOpen = () => setShow(true);
//   const changeClose = () => setShow(false);

  var addToList = e => {
    e.preventDefault();
    setNewListItem([...newListItem, input.current.value]);
  };

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};


  return (
    <div className="NewInventory">
     <Typography>What do I need for my camping trip</Typography>
     
     <Button onClick={handleOpen}>Add to the List</Button>
      <Modal
        variant="contained"
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <Typography id="modal-modal-title" variant="h6" component="h2" align="center">
            My Inventory
          </Typography>
          <Stack>
          <TextField  ref={input}></TextField>
          <Button variant="contained" style={{maxWidth: '150px', justifyContent: 'right', padding: '5px'}} onSubmit={addToList} type="submit">Add to backpack</Button>
          </Stack>
        </Box>
      </Modal>

      <ul>
        {newListItem.map((item, b) => (
          <li key={b}>{item}</li>
        ))}
      </ul>

    </div>
  );
}

export default NewInventory;
