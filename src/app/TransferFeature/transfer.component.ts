import { Component } from "@angular/core";
import { AccountService } from "../services/accounts.service";
import { TransferFormat } from "../Models/transfer";

@Component({
    selector:'app-transfer',
    templateUrl:'transfer.component.html'
})
export class TransferComponent{

    isNegative = false
    isError = false
    transferred = false

    model:TransferFormat={
        id1:0,
        id2:0,
        amount:0
    }

    constructor(private service: AccountService){

    }

    refresh(){
        window.location.reload()
    }

    transfer(){
        this.service.transfer(this.model).subscribe(
            res=>{
                console.log(res)
                if(this.model.amount>0)
                    this.transferred = true
                else
                    this.isNegative = true
            },
            err=>{
                //alert("An error has occurred")
                this.isError = true
            }
        )
    }

}