import 'reflect-metadata';
import { AsyncMockProvider } from '../mocks/mock.async';



describe('Asynchronous service calls', () =>
{
   let synced : AsyncMockProvider;

   beforeEach(() =>
   {
      synced = new AsyncMockProvider();
   });

   test('Returns a promise', async () =>
   {
      expect.assertions(1);


      // 1. Write the promise this way
      /*return synced.fetchByPromise(1).then((data) =>
      {
         expect(data).toBe('First');
      });*/


      // 2. Handle the promise with .resolves method instead
      //return expect(synced.fetchByPromise(1)).toPromise().resolves.toBe('First');


      // 3. Handle the promise using the await keyword
      //const str = await synced.fetchByPromise(1);
      //await expect(str).toBe('First');


      // 4. Example #3 can be rewritten like so
      await expect(synced.fetchByPromise(1)).resolves.toBe('First');

   });

});