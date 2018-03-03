using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Model;
using Repository;

namespace Cyberpunk.Controllers
{
    [Produces("application/json")]
    [Route("api/[controller]")]
    public class CloneController : ControllerBase, IController<CloneModel>
    {
        [HttpPut("add")]
        public async Task<IActionResult> AddAsync([FromBody] CloneModel model)
        {
            IActionResult result = null;

            var b = new BaseEntityDTO<CloneModel>() { Start = DateTime.Now };

            try
            {
                await new CloneRepository().AddAsync(model);

                b.Itens = 1;
                b.Total = 1;

                result = Ok(b);
            }
            catch (Exception err)
            {
                b.Error = (err.InnerException ?? err).Message;
                result = BadRequest(b);
            }
            finally
            {
                b.End = DateTime.Now;
            }

            return result;
        }

        [HttpDelete("delete")]
        public async Task<IActionResult> DeleteAsync([FromBody] CloneModel model)
        {
            IActionResult result = null;

            var b = new BaseEntityDTO<CloneModel>() { Start = DateTime.Now };

            try
            {
                await new CloneRepository().DeleteAsync(model);

                result = Ok(b);
            }
            catch (Exception err)
            {
                b.Error = (err.InnerException ?? err).Message;
                result = BadRequest(b);
            }
            finally
            {
                b.End = DateTime.Now;
            }

            return result;
        }

        [HttpGet("getall")]
        public async Task<IActionResult> GetAllAsync()
        {
            IActionResult result = null;

            var b = new BaseEntityDTO<IEnumerable<CloneModel>>() { Start = DateTime.Now };

            try
            {
                var r = await new CloneRepository().GetAllAsync(new CloneModel { });

                if (r == null || !r.Any())
                    return NoContent();

                b.Result = r;
                b.Itens = r.Count();
                b.Total = r.Count();

                result = Ok(b);
            }
            catch (Exception err)
            {
                b.Error = (err.InnerException ?? err).Message;
                result = BadRequest(b);
            }
            finally
            {
                b.End = DateTime.Now;
            }

            return result;
        }
                
        [HttpPatch("update")]
        public async Task<IActionResult> UpdateAsync([FromBody] CloneModel model)
        {
            IActionResult result = null;

            var b = new BaseEntityDTO<CloneModel>() { Start = DateTime.Now };

            try
            {
                await new CloneRepository().UpdateAsync(model);

                b.Itens = 1;
                b.Total = 1;
                result = Ok(b);
            }
            catch (Exception err)
            {
                b.Error = (err.InnerException ?? err).Message;
                result = BadRequest(b);
            }
            finally
            {
                b.End = DateTime.Now;
            }

            return result;
        }
    }
}
