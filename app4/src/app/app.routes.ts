import{Routes} from '@angular/router'

import{PainelComponent} from './painel/painel.component'
import{ConsultaComponent} from './consulta/consulta.component'

export const ROUTES: Routes=[

    {path:'',component:PainelComponent},
    {path:'consulta',component:ConsultaComponent}
]