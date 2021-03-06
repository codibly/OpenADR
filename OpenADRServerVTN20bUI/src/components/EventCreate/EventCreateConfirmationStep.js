import React from 'react';

import Typography from '@material-ui/core/Typography';

import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';
import FormGroup from '@material-ui/core/FormGroup';

import TextField from '@material-ui/core/TextField';

import ExtensionIcon from '@material-ui/icons/Extension';

import Grid from '@material-ui/core/Grid';


import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormHelperText from '@material-ui/core/FormHelperText';
import Select from '@material-ui/core/Select';

import Divider from '@material-ui/core/Divider';


export class EventCreateConfirmationStep extends React.Component {

  constructor( props ) {
    super( props );
  }


  render() {
    const {classes, descriptor, eventSignal, eventTarget} = this.props;

    return (
    <Grid container
          spacing={ 8 }
          justify="center">
      <Grid container spacing={ 24 }>
          <Grid item xs={ 2 } />
          <Grid item xs={ 4 }>
            <TextField label="Market Context"
                       value={ descriptor.marketContext }
                       className={ classes.textField }
                       margin="dense"
                       variant="outlined"
                       InputProps={ { readOnly: true } }
                       fullWidth={ true } />
          </Grid>
          <Grid item xs={ 1 }>
            <TextField label="Priority"
                       value={ descriptor.priority }
                       className={ classes.textField }
                       margin="dense"
                       variant="outlined"
                       InputProps={ { readOnly: true } }
                       fullWidth={ true } />
          </Grid>
          <Grid item xs={ 1 }>
            <TextField label="Response required"
                       value={ descriptor.responseRequired }
                       className={ classes.textField }
                       margin="dense"
                       variant="outlined"
                       InputProps={ { readOnly: true } }
                       fullWidth={ true } />
          </Grid>
          <Grid item xs={ 2 }>
            <TextField label="Scope"
                       value={ (descriptor.testEvent ) ? "Test Event": "Production Event"}
                       className={ classes.textField }
                       margin="dense"
                       variant="outlined"
                       InputProps={ { readOnly: true } }
                       fullWidth={ true } />
          </Grid>
          <Grid item xs={ 2 } />
        </Grid>

        <Grid container
            style={ { marginTop: 20, marginBottom:10 } }
            spacing={ 24 }>
        <Grid item xs={ 2 } />
        <Grid item xs={ 8 }>
          <Divider />
        </Grid>
        <Grid item xs={ 2 } />
      </Grid>

      {eventSignal.map((signal, index) => {
          return (
             <Grid container spacing={ 24 }  key={"signal_confirmation_panel_"+index}>
                <Grid item xs={ 2 } />
                <Grid item xs={ 2 }>
                  <TextField label="Signal Name"
                             value={ signal.signalName }
                             className={ classes.textField }
                             margin="dense"
                             variant="outlined"
                             InputProps={ { readOnly: true } }
                             fullWidth={ true } />
                </Grid>
                <Grid item xs={ 2 }>
                  <TextField label="Signal Type"
                             value={ signal.signalType }
                             className={ classes.textField }
                             margin="dense"
                             variant="outlined"
                             InputProps={ { readOnly: true } }
                             fullWidth={ true } />
                </Grid>
                <Grid item xs={ 2 }>
                  <TextField label="Unit"
                             value={ signal.unitType }
                             className={ classes.textField }
                             margin="dense"
                             variant="outlined"
                             InputProps={ { readOnly: true } }
                             fullWidth={ true } />
                </Grid>
                <Grid item xs={ 1 }>
                  <TextField label="Current Value"
                             value={ signal.currentValue }
                             className={ classes.textField }
                             margin="dense"
                             variant="outlined"
                             InputProps={ { readOnly: true } }
                             fullWidth={ true } />
                </Grid>
                <Grid item xs={ 1 }>
                  <TextField label="Nb Intervals"
                             value={ signal.intervals.length}
                             className={ classes.textField }
                             margin="dense"
                             variant="outlined"
                             InputProps={ { readOnly: true } }
                             fullWidth={ true } />
                </Grid>
                <Grid item xs={ 2 } />
              </Grid>
              )
        })}

     

         <Grid container
            style={ { marginTop: 20, marginBottom:10 } }
            spacing={ 24 }>
        <Grid item xs={ 2 } />
        <Grid item xs={ 8 }>
          <Divider />
        </Grid>
        <Grid item xs={ 2 } />
      </Grid>
      <Grid container spacing={ 24 }>
          <Grid item xs={ 2 } />
          <Grid item xs={ 2 }>
            <TextField label="Nb Targeted devices"
                       value={ 12 }
                       className={ classes.textField }
                       margin="dense"
                       variant="outlined"
                       InputProps={ { readOnly: true } }
                       fullWidth={ true } />
          </Grid>
          
          <Grid item xs={ 2 } />
        </Grid>
    </Grid>
    );
  }
}

export default EventCreateConfirmationStep;
