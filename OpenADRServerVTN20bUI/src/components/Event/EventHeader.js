import React from 'react';

import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import SearchIcon from '@material-ui/icons/Search';

import Grid from '@material-ui/core/Grid';



import Button from '@material-ui/core/Button';
import AddIcon from '@material-ui/icons/Add';

import GridList from '@material-ui/core/GridList';

import { VtnConfigurationEventCard } from '../common/VtnConfigurationCard'

import { history } from '../../store/configureStore';



import FilterPanel from '../common/FilterPanel' 


export class EventHeader extends React.Component {
  constructor( props ) {
    super( props );


  }

  handleCreateEventClick = () => {
    history.push( '/event/create' );
  }

  render() {
    const {classes, marketContext, event, ven} = this.props;
    return (
      <div>
        <Grid container spacing={ 8 }>
          <Grid container>            
            <Grid item xs={ 11 }>
              <FilterPanel classes={classes} type="EVENT" hasFilter={{marketContext:true, ven: true, eventStatus:true}} 
                marketContext={marketContext}
                filter={this.props.filters}
                onFilterChange={this.props.onFilterChange}
                ven={ven}
                onVenSuggestionsFetchRequested={this.props.onVenSuggestionsFetchRequested}
                onVenSuggestionsClearRequested={this.props.onVenSuggestionsClearRequested}
                onVenSuggestionsSelect={this.props.onVenSuggestionsSelect}
                />
            </Grid>
            <Grid item xs={ 1 }>
             <Button key="btn_create"
                      variant="outlined"
                      color="primary"
                      size="small"
                      fullWidth={ true } 
                      className={ classes.button }
                      onClick={ this.handleCreateEventClick }>
                <AddIcon />New
              </Button>
            </Grid>
           
          </Grid>
        </Grid>  
        
      </div>   
    );
  }
}

export default EventHeader;

