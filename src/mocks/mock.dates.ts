import { Injectable } from '@angular/core';


@Injectable()
export class MockDatesProvider
{
   private _MONTHS : any =  [ "January",
       	   					  "February",
       	   					  "March",
       	   					  "April",
       	   					  "May",
       	   					  "June",
       	   					  "July",
       	   					  "August",
       	   					  "September",
       	   					  "October",
       	   					  "November",
       	   					  "December" ];

   constructor()
   {}

   addLeadingZerosToDateValueIfRequired(digit : number) : string
   {
       let num  : any      =   digit;
       if(num < 10)
       {
           num        =   '0' + num;
       }
       return num;
   }

   returnMonthsOfTheYear() : any
   {
      return this._MONTHS;
   }

   returnCurrentMonth() : any
   {
       let currDate       : any    =   new Date(),
       	   currMonth      : any    =   this._MONTHS[currDate.getMonth()];
       return currMonth;
   }

   returnCurrentDate() : any
   {
       let currDate       : any    =   new Date(),
           currYear       : any    =   currDate.getFullYear(),
           currMonth      : any    =   this.addLeadingZerosToDateValueIfRequired((currDate.getMonth() + 1)),
           currDay        : any    =   this.addLeadingZerosToDateValueIfRequired(currDate.getDate()),
           currDateValue  : any    =   currYear + '-' + currMonth + '-' + currDay;

       return currDateValue;
   }

   returnCurrentTimestamp() : number
   {
       let currentTimestamp : number  =   Math.floor(Date.now()/1000);
       return currentTimestamp;
   }


}