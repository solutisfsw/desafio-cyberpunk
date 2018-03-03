using Newtonsoft.Json;
using System;

namespace Model
{
    public class BaseEntityDTO<T>
    {
        [JsonProperty("start", NullValueHandling = NullValueHandling.Ignore)]
        public DateTime Start { get; set; }
        [JsonProperty("end", NullValueHandling = NullValueHandling.Ignore)]
        public DateTime End { get; set; }
        [JsonProperty("result", NullValueHandling = NullValueHandling.Ignore)]
        public T Result { get; set; }
        [JsonProperty("itens", NullValueHandling = NullValueHandling.Ignore)]
        public int Itens { get; set; }
        [JsonProperty("total", NullValueHandling = NullValueHandling.Ignore)]
        public int Total { get; set; }
        [JsonProperty("error", NullValueHandling = NullValueHandling.Ignore)]
        public string Error { get; set; }
        [JsonProperty("token", NullValueHandling = NullValueHandling.Ignore)]
        public string Token { get; set; }
        [JsonProperty("observacao", NullValueHandling = NullValueHandling.Ignore)]
        public dynamic Observacao { get; set; }
    }
}
