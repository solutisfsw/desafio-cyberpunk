using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;

namespace Cyberpunk.Controllers
{
    public interface IController<T> where T : class
    {
        Task<IActionResult> GetAllAsync();
        Task<IActionResult> AddAsync([FromBody] T model);
        Task<IActionResult> UpdateAsync([FromBody] T model);
        Task<IActionResult> DeleteAsync([FromBody] T model);
    }
}
