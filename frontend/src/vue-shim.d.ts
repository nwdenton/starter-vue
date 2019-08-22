// prevents Typescript Language Service module import error in IDE.
// NOTE: .vue files must be imported with extension
declare module "*.vue" {
    import Vue from 'vue'
    export default Vue
}
