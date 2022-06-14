import { html, LitElement } from 'NodeModules/lit'
import { customElement } from 'NodeModules/lit/decorators.js'

@customElement("my-lit")
export class MyLit extends LitElement {

    render() {
        return html`<div>Je suis une LitElement</div>`;
    }
}