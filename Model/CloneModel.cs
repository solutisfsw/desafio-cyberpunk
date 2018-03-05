using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Model
{
    public class CloneModel : BaseModel
    {
        [JsonProperty("datacriacao", NullValueHandling = NullValueHandling.Ignore)]
        public DateTime DataCriacao { get; set; }

        [JsonProperty("idade", NullValueHandling = NullValueHandling.Ignore)]
        public int Idade { get; set; }

        [JsonProperty("adicionais", NullValueHandling = NullValueHandling.Ignore)]
        public IEnumerable<string> Adicionais { get; set; }
        
        [JsonIgnore]
        public bool IsNomeValid
        {
            get
            {
                if (string.IsNullOrEmpty(Nome))
                    return false;

                var v = Regex.Match(Nome, "([A-Z]{3}[0-9]{4})$", RegexOptions.Compiled);

                return v.Success;                
            }
        }

        [JsonIgnore]
        public bool IsIdadeValid
        {
            get
            {
                return (Idade >= 10 && Idade <= 20);
            }
        }
    }
}
