import { Component, OnInit } from '@angular/core';
import { AccountService } from './services/accounts.service';
import { Account } from './Models/Account';

@Component({
    selector: 'app',
    templateUrl: 'app.component.html'
})
export class AppComponent implements OnInit {
    
    ngOnInit(): void {
    }

    isError = false

    searchId:number
    account:Account
    showResult = false

    refresh(){
        this.isError = false
    }

    constructor(private service : AccountService){}

    search(){
        this.service.findById(this.searchId).subscribe(
            res=>{
                console.log(res)
                this.showResult = true
                this.account = res
            },
            error=>{
                //alert("An error has occurred")
                this.isError = true
            }
        )
    }
        
    
}