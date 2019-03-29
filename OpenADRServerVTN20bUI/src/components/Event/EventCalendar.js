import React from 'react';

import Typography from '@material-ui/core/Typography';
import BigCalendar from 'react-big-calendar'
import moment from 'moment'
import Divider from '@material-ui/core/Divider';

import style from 'react-big-calendar/lib/css/react-big-calendar.css'

import {iCalDurationInSeconds} from '../../utils/time'

import { EventCalendarDialog } from '../common/VtnconfigurationDialog'

import { history } from '../../store/configureStore';

import EventHeader from './EventHeader'

import amber from '@material-ui/core/colors/amber';
import red from '@material-ui/core/colors/red';
import green from '@material-ui/core/colors/green';

import EventCalendarWeekView from './EventCalendarView/EventCalendarWeekView'
import EventCalendarDayView from './EventCalendarView/EventCalendarDayView'
import EventCalendarMonthView from './EventCalendarView/EventCalendarMonthView'
import EventCalendarAgendaView from './EventCalendarView/EventCalendarAgendaView'


const localizer = BigCalendar.momentLocalizer(moment)


var marketContextColorCache = {};
export class EventCalendar extends React.Component {
  constructor( props ) {
    super( props );
    this.state = {}
    this.state.eventCalendarDialog = false;
    this.state.selectedEvent = null;
    this.state.color = "status";
    this.state.view = "week";
    this.state.currentDate = new Date();
   
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    marketContextColorCache = {};
    for(var i in this.props.marketContext) {
      var context = this.props.marketContext[i];
      marketContextColorCache[context.name] = context.color;
    }

  }

  handleEventCalendarDialogClose = () =>  {
    this.setState({eventCalendarDialog: false});
  }

  handleEditEvent = (id) => () => {
    history.push( '/event/detail/'+ id);
  }

  getEventPropGetter = (event, start, end, isSelected) => {
    if(this.state.color == "status") {
      var colorIntensity = 700;
      if(isSelected) {
        colorIntensity = 500;
      }

      var color;
      if(!event.published) {
        color = amber[colorIntensity];
      }
      else if(event.state == "ACTIVE"){
        color = green[colorIntensity];
      }
      else if(event.state == "CANCELLED") {
        color = red[colorIntensity];
      }

      
      return {
        style: {backgroundColor: color}
      }
    }
    else {
      return {
        style: {backgroundColor: marketContextColorCache[event.marketContext]}
      }
    }
      
  }

  handleSelectEvent = (event) => {
    this.setState({eventCalendarDialog: true, selectedEvent:event});
  }

  handleEventDetailClick = (id) => () => {
    history.push( '/event/detail/'+ id);
  }



  render() {
    var that = this;
    const {classes, marketContext, event, ven, filters, pagination, onFilterChange, onPaginationChange,
      start, end, onStartChange, onEndChange, onPeriodChange, onVenSuggestionsFetchRequested, onVenSuggestionsClearRequested, onVenSuggestionsSelect} = this.props;

    var calendarEvent = [];
    event.forEach(e => {
      var start = new Date();
      start.setTime(e.activePeriod.start);
      var end = new Date();
      end.setTime(e.activePeriod.start + iCalDurationInSeconds(e.activePeriod.duration) * 1000);
      calendarEvent.push({
        title:e.descriptor.marketContext+":"+e.id,
        start: start,
        end: end,
        allday:false,
        state: e.descriptor.state,
        published: e.published,
        marketContext:e.descriptor.marketContext,
        id:e.id
      });
    });

   var onColorChange = function(color){
      that.setState({color});
    }

    EventCalendarWeekView.onColorChange = onColorChange;
    EventCalendarWeekView.color = this.state.color;
    EventCalendarDayView.onColorChange = onColorChange;
    EventCalendarDayView.color = this.state.color;
    EventCalendarMonthView.onColorChange = onColorChange;
    EventCalendarMonthView.color = this.state.color;
    EventCalendarAgendaView.onColorChange = onColorChange;
    EventCalendarAgendaView.color = this.state.color;

    
    var getRange = (date, view) => {
      if(view == "agenda"){
        let start = moment(date)
        let end = moment(date);
        end.add(31, 'day')
        return {
          start:start.toDate(),
          end:end.toDate()
        }
      }
      else {
        let start = moment(date).startOf(view);
        let end = moment(date).endOf(view);
        console.log(start, end)
        return {
          start:start.toDate(),
          end:end.toDate()
        }

      }
      
    } 
    


    return (
      <div className={ classes.root }>
        <EventHeader classes={classes}  marketContext={marketContext} event={event}
        filters={filters} pagination={pagination} onFilterChange={onFilterChange} onPaginationChange={onPaginationChange}
        start={start} end={end} onStartChange={onStartChange} onEndChange={onEndChange} 
        ven={ven}
                onVenSuggestionsFetchRequested={onVenSuggestionsFetchRequested}
                onVenSuggestionsClearRequested={onVenSuggestionsClearRequested}
                onVenSuggestionsSelect={onVenSuggestionsSelect}/>
        <Divider style={ { marginBottom: '20px', marginTop: '20px' } } />
        <BigCalendar style={{height:600}}
          localizer={localizer}
          events={calendarEvent}
          defaultView={this.state.view}
          defaultDate={this.state.currentDate}
          startAccessor="start"
          endAccessor="end"
          eventPropGetter={this.getEventPropGetter}
          onSelectEvent={this.handleSelectEvent}
          views={{ month: EventCalendarMonthView, week: EventCalendarWeekView , day: EventCalendarDayView, agenda:EventCalendarAgendaView}}
          onNavigate={(date) => {
            var r = getRange(date, this.state.view);
            onPeriodChange(r.start.getTime(), r.end.getTime());
            this.setState({currentDate:date});
          }}
          onView={(view) => {
            this.setState({view})
            var r = getRange(this.state.currentDate, view);
            onPeriodChange(r.start.getTime(), r.end.getTime());
            }
          }
        />

        {(this.state.selectedEvent) ? <EventCalendarDialog classes={classes} title={(this.state.selectedEvent) ? this.state.selectedEvent.title : ""}
        event={this.state.selectedEvent}
        open={this.state.eventCalendarDialog}
        close={this.handleEventCalendarDialogClose}
        handleEventDetailClick={this.handleEventDetailClick(this.state.selectedEvent.id)}/> : null}
     
      </div>
    );
  }
}

export default EventCalendar;
