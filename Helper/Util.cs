using Microsoft.Extensions.Configuration;
using System;
using System.IO;
using System.Threading.Tasks;

namespace Helper
{
    public static class Util
    {
        public const int TIMEOUTEXECUTE = 888;

        public static IConfigurationRoot Configuration => new ConfigurationBuilder()
            .SetBasePath(Directory.GetCurrentDirectory())
            .AddJsonFile("appsettings.json", optional: true, reloadOnChange: true)
            .Build();
        
        public static string UrlFirebase => Configuration["UrlFirebase"];

        public static string TokenFirebase => Configuration["TokenFirebase"];

        public static DateTime GetTimeServer = DateTime.Parse(DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss"));

        public async static Task<string> AuthToken() => TokenFirebase;
    }
}
