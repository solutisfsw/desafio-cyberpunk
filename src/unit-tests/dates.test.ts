import 'reflect-metadata';
import { MockDatesProvider } from '../mocks/mock.dates';



let date = null;

beforeEach(() => {
   date         = new MockDatesProvider();

});

describe('Dates service', () =>
{

   /**
    * Test that the returned value matches today's date
    *
    */
   test('Returns the current date', () =>
   {
      expect.assertions(1);
      let currentDate         = date.returnCurrentDate();

      expect(currentDate).toEqual("2018-03-03");
   });

   /**
    * Test that the total months of the year are returned
    *
    */
   test('Returns all of the months of the year', () =>
   {
      expect.assertions(2);
      let months              = date.returnMonthsOfTheYear(),
          expected            = ['July', 'November'];

      expect(months).toHaveLength(12);
      expect(months).toEqual(expect.arrayContaining(expected));
   });

   /**
    * Test that the current month is returned
    *
    */
   test('Returns the current month', () =>
   {
      expect.assertions(1);
      let currentMonth        = date.returnCurrentMonth();

      expect(currentMonth).toBe("March");
   });

   /**
    * Test that the current timestamp is returned
    *
    */
   test('Returns the current timestamp', () =>
   {
      expect.assertions(1);
   	let timestamp         = date.returnCurrentTimestamp();
   	expect(timestamp).toBeGreaterThanOrEqual(Math.floor(Date.now()/1000));
   });

});